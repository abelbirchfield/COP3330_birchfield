public class ContactItem {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public ContactItem(String firstName, String lastName, String phoneNumber, String emailAddress) {
        if (isValid(firstName, lastName, phoneNumber, emailAddress)) {
            this.firstName = firstName;
            this.lastName = lastName;
            if ((emailAddress.length() > 0) && (isEmailAddressValid(emailAddress))) {
                this.emailAddress = emailAddress;
            } else if (emailAddress.length() < 1) {
                this.emailAddress = emailAddress;
            } else {
                throw new InvalidEmailAddressException("WARNING: invalid email address; contact not created");
            }
            if ((phoneNumber.length() > 0) && (isPhoneNumberValid(phoneNumber))) {
                this.phoneNumber = phoneNumber;
            } else if (phoneNumber.length() < 1) {
                this.phoneNumber = phoneNumber;
            } else {
                throw new InvalidPhoneNumberException("WARNING: invalid phone number; contact not created");
            }
        } else {
            throw new AllBlankException("WARNING: all values cannot be blank; contact not created");
        }

    }

    private boolean isValid(String firstName, String lastName, String phoneNumber, String emailAddress) {
        if ((firstName.length() < 1) && (lastName.length() < 1) && (phoneNumber.length() < 1) && (emailAddress.length() < 1)) {
            return false;
        } else {
            return true;
        }
    }
    private boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber.length() != 12) {
            throw new InvalidPhoneNumberException("WARNING: invalid phone number; contact not created");
        }
        try {
            int areaCode = Integer.parseInt(phoneNumber.substring(0, 3));
            int firstThreeDigits = Integer.parseInt(phoneNumber.substring(4, 7));
            int lastFourDigits = Integer.parseInt(phoneNumber.substring(8));
            if (phoneNumber.substring(3, 4).equals("-") && phoneNumber.substring(7, 8).equals("-")) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private boolean isEmailAddressValid(String emailAddress) {
        return (emailAddress.contains("@") && emailAddress.contains("."));
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return this.lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() < 1 || isPhoneNumberValid(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new InvalidPhoneNumberException("WARNING: invalid phone number; contact not created");
        }
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        if (emailAddress.length() < 1 || isEmailAddressValid(emailAddress)) {
            this.emailAddress = emailAddress;
        } else {
            throw new InvalidEmailAddressException("WARNING: invalid email address; contact not created");
        }
    }
    public String getEmailAddress() {
        return this.emailAddress;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s%nPhone: %s%nEmail: %s", this.firstName, this.lastName, this.phoneNumber, this.emailAddress);
    }
}

class AllBlankException extends IllegalArgumentException {
    public AllBlankException(String message) {
        super(message);
    }
}
class InvalidPhoneNumberException extends IllegalArgumentException {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
class InvalidEmailAddressException extends IllegalArgumentException {
    public InvalidEmailAddressException(String message) {
        super(message);
    }
}
