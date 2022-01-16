package uz.xtreme.stadio.core.validation;

public abstract class Validator {
    private Validator next;

    public Validator with(Validator validator) {
        this.next = validator;
        return this.next;
    }

    public abstract void verify();

    public void verifyNext() {
        if (this.next != null)
            this.next.verify();
    }
}
