package Day02.test;

import Day02.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static int Index = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        lo:
        while (true) {
            System.out.println("--------欢迎来到 <学生> 管理系统--------" );
            System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出" );
            String choose = sc.next();
            switch (choose) {
                case "1":
                    addstudent(list);

                    break;
                case "2":
                    deletestudent(list);
                    break;
                case "3":
                    updataStudent(list);

                    break;
                case "4":
                    showStudent(list);
                    break;
                case "5":
                    break lo;
                default:
                    System.out.println("输入有误" );
                    break;

            }
        }
    }

    private static void showStudent(ArrayList<Student> list) {
        System.out.println("学号\t\t姓名\t年龄\t生日" );
        for (Student student : list) {
            System.out.println(student.getSid() + "\t\t" + student.getName() + "\t" + student.getAge() + "\t" + student.getBirthday());

        }
    }

    private static void updataStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学号" );
        int id = sc.nextInt();
        Index = getIndex(id, list);
        if (Index == -1) {
            System.out.println("学号不存在，请重新输入" );
        } else {
            System.out.println("请输入学号" );
            id = sc.nextInt();
            System.out.println("请输入姓名" );
            String name = sc.next();
            System.out.println("请输入年龄" );
            int age = sc.nextInt();
            System.out.println("请输入生日" );
            int birth = sc.nextInt();
            Student stu = list.get(Index);
            stu.setSid(id);
            stu.setName(name);
            stu.setAge(age);
            stu.setBirthday(birth);
        }
    }

    private static void deletestudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除学号" );
        int id = sc.nextInt();
        Index = getIndex(id, list);
        if (Index == -1) {
            System.out.println("学号不存在，请重新输入" );
        } else {
            list.remove(Index);
            System.out.println("删除成功" );
        }
    }

    public static void addstudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        int id = 0;
        while (true) {
            System.out.println("请输入学号" );
            id = sc.nextInt();
            Index = getIndex(id, list);
            if (Index == -1) {
                break;
            }
        }
        System.out.println("请输入姓名" );
        String name = sc.next();
        System.out.println("请输入年龄" );
        int age = sc.nextInt();
        System.out.println("请输入生日" );
        int birth = sc.nextInt();
        Student student = new Student(id, name, age, birth);
        list.add(student);
        System.out.println("添加成功" );
    }

    public static int getIndex(int id, ArrayList<Student> list) {
        int Index = -1;
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (id == stu.getSid()) {
                Index = i;
            }
        }
        return Index;
    }


}
