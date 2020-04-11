package com.power.fast.modules.sys.enums;

/**
 * @author fei
 * @title: MenuTypeEnum
 * @projectName renren-fast
 * @description: 菜单类型枚举
 * @date 2020/4/11 11:44
 */
public enum MenuTypeEnum {
    /**
     * 目录
     */
    CATALOG(0),
    /**
     * 菜单
     */
    MENU(1),
    /**
     * 按钮
     */
    BUTTON(2);
    private int value;

    MenuTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
