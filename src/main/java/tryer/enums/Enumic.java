package tryer.enums;

public enum Enumic implements WTF {

    ONE{
        @Override
        public String wtf() {
            return "first";
        }
    }, TWO {
        @Override
        public String wtf() {
            return "second";
        }
    }, THREE {
        @Override
        public String wtf() {
            return "third";
        }
    }

}

interface WTF {
    String wtf();
}



