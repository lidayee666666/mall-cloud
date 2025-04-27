package com.mall.user.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Component
public class SensitiveWordFilter {
    private static final Logger log = LoggerFactory.getLogger(SensitiveWordFilter.class);
    private final TrieNode root = new TrieNode(); // Trie根节点
    private static final char REPLACE_CHAR = '*'; // 替换字符

    @PostConstruct
    public void init() {
        try {
            ClassPathResource resource = new ClassPathResource("sensitive-words.json");
            try (InputStream is = resource.getInputStream()) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode wordsNode = mapper.readTree(is).get("sensitive_words");

                // 构建Trie树
                wordsNode.forEach(node -> {
                    String word = node.asText().trim();
                    addWord(word.toLowerCase()); // 统一转小写处理
                });
                log.info("Trie树构建完成，敏感词数量：{}", wordsNode.size());
            }
        } catch (Exception e) {
            log.error("初始化敏感词失败，使用默认词库", e);
            addDefaultWords();
        }
    }

    private void addWord(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                current.addChild(ch, new TrieNode());
            }
            current = current.getChild(ch);
        }
        current.setEnd(true);
    }

    private void addDefaultWords() {
        Stream.of("垃圾", "违法", "广告", "脑瘫", "智障")
                .forEach(this::addWord);
    }

    /**
     * 核心DFA检测算法，返回详细的过滤结果
     */
    public SensitiveFilterResult filterContent(String text) {
        if (StringUtils.isEmpty(text)) {
            return SensitiveFilterResult.cleanResult();
        }

        text = text.toLowerCase(); // 统一转小写
        char[] chars = text.toCharArray();
        Set<String> sensitiveWords = new HashSet<>();
        boolean containsSensitive = false;

        TrieNode node;
        for (int i = 0; i < chars.length; i++) {
            node = root;
            int start = i;
            while (start < chars.length) {
                node = node.getChild(chars[start]);
                if (node == null) break;

                if (node.isEnd()) {
                    // 发现敏感词
                    String sensitiveWord = text.substring(i, start + 1);
                    sensitiveWords.add(sensitiveWord);
                    Arrays.fill(chars, i, start + 1, REPLACE_CHAR); // 替换敏感词
                    containsSensitive = true;
                    i = start; // 跳过已处理部分
                    break;
                }
                start++;
            }
        }

        String filteredContent = new String(chars);
        return new SensitiveFilterResult(containsSensitive, sensitiveWords, filteredContent);
    }
}