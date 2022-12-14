package com.zjz.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zjz
 * @date 2021/10/27 17:22
 */
public class ConsumerTest {

    public static void main(String[] args) {
//        List<Person> lisiList = new ArrayList<>();
//        // 就是一个匿名函数
//        Consumer<Person> consumer  = x -> {
//            if (x.name.equals("lisi")){
//                lisiList.add(x);
//            }
//        };
//        Stream.of(
//                new Person(21,"zhangsan"),
//                new Person(22,"lisi"),
//                new Person(23,"wangwu"),
//                new Person(24,"wangwu"),
//                new Person(23,"lisi"),
//                new Person(26,"lisi"),
//                new Person(26,"zhangsan")
//        ).forEach(consumer);
//
////        System.out.println(JSONUtil.toJsonStr(lisiList));
//
//        List<Person> collect = Stream.of(
//                new Person(21, "zhangsan"),
//                new Person(22, "lisi"),
//                new Person(27, "wangwu"),
//                new Person(24, "wangwu"),
//                new Person(23, "lisi"),
//                new Person(26, "lisi"),
//                new Person(26, "zhangsan")
//        ).collect(Collectors.toList());
//
//        System.out.println(JSONUtil.toJsonStr(collect));
//        List<Person> collect1 = collect.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
//        System.out.println(JSONUtil.toJsonStr(collect1));
//
//
//        collect.forEach(item -> {
//            if (item.getAge() == 21) return;
//            System.out.println(item.age + item.getName());
//        });

//        Set<Long> set = new HashSet<>();
//        set.add(1L);
//        set.add(2L);
//        set.add(3L);
//        Set<Long> set1 = new HashSet<>();
//        set1.add(1L);
//        set1.add(2L);
//        set1.add(4L);
//
//        boolean b = set.addAll(set1);
//        System.out.println(b);
//        System.out.println(set);


        Person person = new Person(12, "A");
        Person person1 = new Person(13, "B");
        Person person2 = new Person(11, "C");
        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person1);
        list.add(person2);

        List<Person> collect = list.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());
        System.out.println(collect);

        String bankCountInfo = "已绑卡%s张";

        System.out.println(String.format(bankCountInfo, 2));

    }

    public static class Person {
        private Integer age;
        private String name;

        Person(){}

        Person(Integer age, String name){
            this.age = age;
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
