package QuanLyDanhBa;

import java.util.Scanner;

public class Contact {
    Scanner input = new Scanner(System.in);
    private String phoneNumber;
    private String group;
    private String hoTen;
    private String gender;
    private String dateBorn;
    private String address;
    private String email;
    public Contact() {
    }

    public Contact(String phoneNumber, String group, String hoTen, String gender, String dateBorn, String address, String email) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.hoTen = hoTen;
        this.gender = gender;
        this.dateBorn = dateBorn;
        this.address = address;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        if(phoneNumber.matches("^[0]\\d{8,9}$")){
            this.phoneNumber = phoneNumber;
            return true;
        }
        System.err.println("Input data is incorrect ");
        return false;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if(email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")){
            this.email = email;
            return true;
        }
        System.err.println("Input data is incorrect ");
        return false;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", group='" + group + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", gender='" + gender + '\'' +
                ", dateBorn='" + dateBorn + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public Contact inputContact(){
        System.out.println("Nhập số điện thoại");
        String phoneNumber;
        do {
            System.out.println("Input phone number (0123456789 or 01234567890)");
            phoneNumber = input.nextLine();
        }while (!setPhoneNumber(phoneNumber));
        System.out.println("Nhập nhóm");
        String group = input.nextLine();
        System.out.println("Nhập họ tên");
        String hoTen = input.nextLine();
        System.out.println("Nhập giới tính");
        String gender = input.nextLine();
        System.out.println("Nhập ngày sinh");
        String dateBorn = input.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = input.nextLine();
        System.out.println("Nhập email");
        String email;
        do{
            System.out.println("Input email (abc@xyz.com)");
            email = input.nextLine();
        }while (!setEmail(email));
        return new Contact(phoneNumber,group,hoTen,gender,dateBorn,address,email);

    }


}

