package QuanLyDanhBa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ContactManager {
    List<Contact> contactList = new ArrayList<>();
    Contact contact = new Contact();
    Scanner input = new Scanner(System.in);

    public void showMenu(){
        System.out.println("---- Chương trình quản lý danh bạ ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục): ");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Ghi từ file");
        System.out.println("7. Đọc từ file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng: ");

    }
    public void createContact(){
        contactList.add(new Contact("0123456789","1","Nguyễn Văn A","Nam","01/08/1993","Ha Noi","Anh@gmail.com"));
        contactList.add(new Contact("0837123612","2","Nguyễn Linh","Nữ","03/02/1995","Ha Noi","linh12@gmail.com"));

    }
    public void showList(){
        for (Contact s: contactList) {
            System.out.println(s);
        }
    }

    public void addContact(){
        contactList.add(contact.inputContact());
        for (Contact s: contactList) {
            System.out.println(s);
        }
    }

    public void myMenu(){
        showMenu();
        int key = -1;
        do{
            key = input.nextInt();
            switch (key){
                case 1:
                    showList();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    replaceInformation();
                    break;
                case 4:
                    deleteInformation();
                    break;
                case 5:
                    showInformationByPhoneNumber();
                    break;
                case 6:
                    saveDataToFile();
                    break;
                case 7:
                    readFile();
                    break;
                case 8:
                    System.exit(8);
                    break;
            }

        }while (key != 8);
    }
    public void readFile() {
        try {
            String content = readFromFile();
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String readFromFile() throws Exception {
        File file = new File("Data\\contacts.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String content = "";
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content = content.concat(line);
            content = content.concat("\n");
        }
        return content;
    }
    public void saveDataToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\Data\\contacts.csv"))) {
            bw.write("Số điện thoại");
            bw.write(",");
            bw.write("Nhóm");
            bw.write(",");
            bw.write("Họ tên");
            bw.write(",");
            bw.write("Giới tính");
            bw.write(",");
            bw.write("Địa chỉ");
            bw.write(",");
            bw.write("Ngày sinh");
            bw.write(",");
            bw.write("Email");
            bw.newLine();
            for (Contact data : contactList) {
                bw.write(String.valueOf(contactList));
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showInformationByPhoneNumber() {
        int check = checkPhoneNumber();
        if (check != -1) {
            System.out.println(contactList.get(check));
        } else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
            showInformationByPhoneNumber();
        }
    }
    public void deleteInformation() {
        int check = checkPhoneNumber();
        if (check != -1) {
            System.out.println("Nhập yes để xóa");
            String y = input.nextLine();
            if (y.equals("yes")) {
                contactList.remove(check);
                showMenu();
                System.out.println("Nhập lựa chọn menu");
            } else {
                myMenu();

            }
        } else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
            deleteInformation();
        }
    }
    public void replaceInformation() {
        int check = checkPhoneNumber();
        if (check != -1) {
            System.out.println("Đổi mới thông tin người dùng");
            System.out.println("Đổi mới tên");
            contactList.get(check).setHoTen(input.nextLine());
            System.out.println("Đổi mới ngày sinh");
            contactList.get(check).setDateBorn(input.nextLine());
            System.out.println("Đổi mới giới tính");
            contactList.get(check).setGender(input.nextLine());
            System.out.println("Đổi mới địa chỉ");
            contactList.get(check).setAddress(input.nextLine());
            System.out.println("Đổi mới email");
            contactList.get(check).setEmail(input.nextLine());
            System.out.println("Đổi mới group");
            contactList.get(check).setGroup(input.nextLine());
            System.out.println("Success!");
        } else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
            replaceInformation();
        }
    }
    public int checkPhoneNumber() {
        int index = -1;
        System.out.println("Nhập số điện thoại cần sửa: ");
        input.nextLine();
        String phone = input.nextLine();
        for (int i = 0; i < contactList.size(); i++) {
            if (phone.equals(contactList.get(i).getPhoneNumber())) {
                return i;
            }
        }
        return index;
    }

}