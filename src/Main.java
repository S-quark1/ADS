import db.StudentDB;
import db.Student;
import db.StudentRepos;
import hash_and_bst.HashTable;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDB db = new StudentDB();
        StudentRepos studentRepos = new StudentRepos(db);
        List<Student> students = studentRepos.getAll();
        HashTable<Integer, Student> table = new HashTable<>();
        for (Student student: students) {
            table.put(student.getId(), student);
            System.out.println(table.get(student.getId()));
        }
//        BST<Integer, Integer> bst = new BST<>();
//        bst.put(1,1);
//        bst.put(2,2);
//        bst.put(4,4);
//        bst.put(7,7);
//        bst.put(5,5);
//        bst.put(0,0);
//        bst.put(3,3);
//        bst.put(6,6);
//        for (Integer element : bst) {
//            System.out.print(element + " ");
//        }
//        bst.iterator();
//        System.out.println("\nooo"+ bst.getNode(4));
////        System.out.print(bst.getNode(5));
//        bst.delete(3);
//        System.out.println();
//        bst.iterator();
    }
}
