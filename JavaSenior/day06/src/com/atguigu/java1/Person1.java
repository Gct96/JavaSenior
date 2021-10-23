package com.atguigu.java1;

/**
 * @author KeyboardHero
 * @create 2021-10-23 17:24
 */
public class Person1 {
    public int id;
    public String name;

    public Person1() {
    }

    public Person1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person1 person1 = (Person1) o;

        if (id != person1.id) return false;
        return name != null ? name.equals(person1.name) : person1.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
