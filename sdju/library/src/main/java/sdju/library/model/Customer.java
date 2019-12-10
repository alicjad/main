package sdju.library.model;

public class Customer {

    private int customerId;
    private String customerName;
    private CustomerGrade grade;
    private String emailAddress;
    private String phoneNumber;

    public Customer(int customerId, String customerName, CustomerGrade grade,
                    String emailAddress, String phoneNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.grade = grade;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public Customer(){}

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerGrade getGrade() {
        return grade;
    }

    public void setGrade(CustomerGrade grade) {
        this.grade = grade;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", grade=" + grade +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

}
