package com.easy.filter;

import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.annotation.WebFilter;

/**
 * 使delete和put方法能够使用
 */
@WebFilter({"/*", "/*/**"})
public class MyHiddenHttpMethodFilter extends HiddenHttpMethodFilter {

}
