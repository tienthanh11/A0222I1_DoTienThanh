package ss10_DSA_DanhSach.BaiTap.TrienKhaiCacPhuongThucCuaLinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        class Student {
            private int id;
            private String name;

            public Student() {
            }

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        Student student1 = new Student(1, "Thành");
        Student student2 = new Student(2, "Trí");
        Student student3 = new Student(3, "Thư");
        Student student4 = new Student(4, "Hoàng");
        Student student5 = new Student(5, "Trung");

        myLinkedList.addFirst(student1);
        myLinkedList.addFirst(student2);
        myLinkedList.addLast(student3);
        myLinkedList.addLast(student4);

//        myLinkedList.remove(3);

//        myLinkedList.remove(student4);

/*        for(int i = 0; i < myLinkedList.size(); i++) {
            Student student = (Student) myLinkedList.get(i);
            System.out.println(student.getId() + "\t" + student.getName());
        }*/

        /*MyLinkedList<Student> cloneLinkedList = myLinkedList.clone();

        for(int i = 0; i < cloneLinkedList.size(); i++) {
            Student student = (Student) cloneLinkedList.get(i);
            System.out.println(student.getId() + "\t" + student.getName());
        }*/

//        System.out.println(myLinkedList.contains(student5));

        System.out.println(myLinkedList.indexOf(student3));
    }
}
