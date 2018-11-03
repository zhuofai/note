# 正则表达式(Regular expressions)

>一般来说,正则表达式就是以某种方式来描述字符串.

1. 要找一个数字,它可能有一个负号在最前面,那你就写一个符号加上一个问号,就像这样-?
2. 在正则表达式中,用\d表示一位数字,如果在其他语言中使用过正则表达式,就能发现java对反斜线\的不同处理.
3. 在其他语言中,\\表示"我想要在正则表达式中插入一个普通的(字面上)反斜线",请不要给它任何特殊的意义."而在java中,\\的意思是"我要插入一个正则表达式的反斜线,所以其后的字符具有特殊的意义"例:如果你想要表示一个数字,那么正则表达式应该时\\d.如果想插入一个普通的反斜线,则应该\\\\.不过换行和制表只需要使用单反斜线\n\t
4. 要表示"一个或多个之前的表达式",应该使用+
5. 在正则表达式中,括号有着将表达式分组的效果,而竖直线|则表示或操作.
6. 例:(-|\\+)?这个表示字符串的初始字符可能是一个-或+,或二者皆没有(因为后面跟着?修饰符(一个问号表示一个或零个))

![Pattern-characters](../notepicture/day806-regular-characters.png)

![Pattern-charactersClasses](../notepicture/day806-regular-charClass.png)

![Pattern-operation](../notepicture/day806-regular-operation.png)

![Pattern-quantifier](../notepicture/day806-regular-quantifier.png)

1. 构造功能强大的正则表达式对象.只需导入java.util.regex包,然后用static Pattern.compile()方法来编译你的正则表达式即可.
2. 它会根据你的String类型的正则表达式产生一个Pattern对象,接下来,把你想要检索的字符串传入Pattern对象的matcher()方法.matcher()方法会产色很难过一个Matcher对象,他有很多功能可用

```java
public class Finding {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\w+").matcher("Evening is full of the linnet's wings");
        while(m.find())
            System.out.print(m.group() + " ");
        System.out.println();
        int i = 0;
        while(m.find(i)){
            System.out.print(m.group() + " ");
            i++;
        }
    }
}
```
