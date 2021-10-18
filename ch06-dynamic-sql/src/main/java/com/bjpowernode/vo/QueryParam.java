package com.bjpowernode.vo;

/**
 * 2021/9/8 20:10
 */
public class QueryParam {
    private String paramName;
    private Integer paramAge;

    public QueryParam(String paramName, Integer paramAge) {
        this.paramName = paramName;
        this.paramAge = paramAge;
    }

    public QueryParam() {
    }

    public String getParamName() {
        return paramName;
    }

    public Integer getParamAge() {
        return paramAge;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public void setParamAge(Integer paramAge) {
        this.paramAge = paramAge;
    }

    @Override
    public String toString() {
        return "QueryParam{" +
                "paramName='" + paramName + '\'' +
                ", paramAge=" + paramAge +
                '}';
    }
}
