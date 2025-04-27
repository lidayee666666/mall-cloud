package com.mall.user.filter;

import lombok.Getter;

import java.util.Collections;
import java.util.Set;

/**
 * @author 李青龙
 * @date 2025/04/22 13:52
 * @description 功能描述:
 * @since JDK 1.8
 */
public class SensitiveFilterResult {

    private boolean containsSensitive;

    @Getter
    private Set<String> sensitiveWords;

    @Getter
    private String filteredContent;

    public SensitiveFilterResult(boolean containsSensitive, Set<String> sensitiveWords, String filteredContent) {
        this.containsSensitive = containsSensitive;
        this.sensitiveWords = sensitiveWords;
        this.filteredContent = filteredContent;
    }

    public static SensitiveFilterResult cleanResult() {
        return new SensitiveFilterResult(false, Collections.emptySet(), "");
    }

    public boolean containsSensitive() {
        return containsSensitive;
    }

}