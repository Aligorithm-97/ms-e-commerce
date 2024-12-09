package com.aligorithm.ecommerce.exception;

public class CustomerNotFoundException extends RuntimeException {

    private final String msg;

    public CustomerNotFoundException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public String toString() {
        return "CustomerNotFoundException(msg=" + this.getMsg() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CustomerNotFoundException)) return false;
        final CustomerNotFoundException other = (CustomerNotFoundException) o;
        if (!other.canEqual((Object) this)) return false;
        if (!super.equals(o)) return false;
        final Object this$msg = this.getMsg();
        final Object other$msg = other.getMsg();
        if (this$msg == null ? other$msg != null : !this$msg.equals(other$msg)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CustomerNotFoundException;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final Object $msg = this.getMsg();
        result = result * PRIME + ($msg == null ? 43 : $msg.hashCode());
        return result;
    }
}
