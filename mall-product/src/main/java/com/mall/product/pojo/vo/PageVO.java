package com.mall.product.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @author flash
 * date 2025/03/26 15:47
 * 功能描述:
 */
@Data
public class PageVO<VO> {
    private Long total;
    private Long pages;
    private List<VO> list;

    private PageVO() {
    }

    public static <VO> PageVO<VO> of(Long total, Long pages, List<VO> list) {
        PageVO<VO> pageVO = new PageVO<>();
        pageVO.total = total;
        pageVO.pages = pages;
        pageVO.list = list;
        return pageVO;
    }
}
