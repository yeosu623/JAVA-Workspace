import java.util.HashSet;

class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "(" + age + "세)";
    }

    @Override
    public int hashCode() { return name.hashCode() + (age % 7); }

    @Override
    public boolean equals(Object obj) {
        String n = ((Person)obj).name;
        int a = ((Person)obj).age;

        if(this.name.equals(n) && (this.age == a))
            return true;
        else
            return false;
    }
}

class CollectionProblem1 {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        set.add(new Person("aaa", 10));
        set.add(new Person("aaa", 10));

        System.out.println("인스턴스 수 : " + set.size());
        for(Person person : set)
            System.out.println(person.toString() + "\t");
    }
}