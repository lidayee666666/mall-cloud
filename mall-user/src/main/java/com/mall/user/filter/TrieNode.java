package com.mall.user.filter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李青龙
 * @date 2025/04/22 13:46
 * @description 功能描述:
 * @since JDK 1.8
 */
public class TrieNode {

    // 子节点（使用Map实现快速查找）
    final Map<Character, TrieNode> children = new HashMap<>();
    // 是否敏感词结尾
    private boolean isEnd = false;

    public TrieNode getChild(Character ch) {
        return children.get(ch);
    }

    public void addChild(Character ch, TrieNode node) {
        children.put(ch, node);
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
