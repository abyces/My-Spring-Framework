package org.zywang.myspring.aop.aspectj;

import org.aopalliance.aop.Advice;
import org.zywang.myspring.aop.Pointcut;
import org.zywang.myspring.aop.PointcutAdvisor;

public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    // 切面
    private AspectJExpressionPointcut pointcut;
    // 拦截器
    private Advice advice;
    // 表达式
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (pointcut == null) {
            pointcut = new AspectJExpressionPointcut(expression);
        }

        return pointcut;
    }


}
