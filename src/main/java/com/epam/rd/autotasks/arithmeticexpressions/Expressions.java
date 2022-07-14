package com.epam.rd.autotasks.arithmeticexpressions;

import java.util.StringJoiner;

public class Expressions {

    public static Variable var(String name, int value) {
        return new Variable(name, value);
    }

    public static Expression val(int value) {
        Expression exp = new Expression() {
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                if (value<0)
                    return "("+value+")";
                else
                    return Integer.toString(value);
            }
        };
        return exp;
    }

    public static Expression sum(Expression... members){
        Expression exp =new Expression() {
            @Override
            public int evaluate() {
                int sum=0;
                for (Expression member: members) {
                    sum+=member.evaluate();
                }
                return sum;
            }

            @Override
            public String toExpressionString() {
                StringBuilder s=new StringBuilder();
                s.append("(");
                for (int i = 0; i < members.length; i++) {
                    s.append(members[i].toExpressionString());
                    if (i!= members.length-1)
                        s.append(" + ");
                }
                s.append(")");
                return s.toString();
            }
        };
        return exp;
    }

    public static Expression product(Expression... members){
        return new Expression() {
            @Override
            public int evaluate() {
                int sum=1;
                for (Expression member: members) {
                    sum*=member.evaluate();
                }
                return sum;
            }

            @Override
            public String toExpressionString() {
                StringBuilder s=new StringBuilder();
                s.append("(");
                for (int i = 0; i < members.length; i++) {
                    s.append(members[i].toExpressionString());
                    if (i!= members.length-1)
                        s.append(" * ");
                }
                s.append(")");
                return s.toString();
            }
        };
    }

    public static Expression difference(Expression minuend, Expression subtrahend){
        return new Expression() {
            @Override
            public int evaluate() {
                return minuend.evaluate()-subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "("+minuend.toExpressionString()+" - "+subtrahend.toExpressionString()+")";
            }
        };
    }

    public static Expression fraction(Expression dividend, Expression divisor){
        return new Expression() {
            @Override
            public int evaluate() {
                return dividend.evaluate()/divisor.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "("+dividend.toExpressionString()+" / "+divisor.toExpressionString()+")";
            }
        };
    }

}
