package ss10_DSA_DanhSach.BaiTap.TrienKhaiCacPhuongThucCuaArrayList;

public class MyListTest {
    public static class Student {
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

        public static void main(String[] args) {
            Student a = new Student(1, "Thành");
            Student b = new Student(2, "Tuấn");
            Student c = new Student(3, "Hùng");
            Student d = new Student(4, "Du");
            Student e = new Student(5, "Hoàng");
            Student f = new Student(6, "Thư");

            //Khai báo MyList kdl Student, add vào
            MyList<Student> myList = new MyList<>();
            // Khai báo 1 MyList mới cho method clone
            MyList<Student> newMyList = new MyList<>();

            myList.add(a);
            myList.add(b);
            myList.add(c);
            myList.add(d);
            myList.add(e);
//            myList.add(f, 2);
/*            myList.clear();
            for(int i = 0; i < myList.size(); i++) {
                Student student = (Student) myList.elements[i];
                System.out.println(student.getId());
                System.out.println(student.getName());
            }*/

            myList.size();
            System.out.println(myList.size());
//            System.out.println(myList.get(2).getName());

//            System.out.println(myList.indexOf(f));

//            System.out.println(myList.contains(f));

            newMyList = myList.clone();

/*            newMyList.remove(1);
            for(int i = 0; i < newMyList.size(); i++) {
                System.out.println(newMyList.get(i).getName());
            }*/

            Student student = newMyList.remove(2);
            System.out.println(student.getName());
        }
    }
}
