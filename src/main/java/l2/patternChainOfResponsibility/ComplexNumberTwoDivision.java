package l2.patternChainOfResponsibility;

import l2.ComplexNumber.ComplexNumber;

public class ComplexNumberTwoDivision implements Chain {
        private Chain chain;

        @Override
        public void setNextChain(Chain nextChain) {
            this.chain=nextChain;
        }

        @Override
        public void method(ComplexNumber number) {
            double r = Double.parseDouble(number.getReal());
            double i =Double.parseDouble(number.getImaginary().replaceFirst(".$",""));
            if (r >= 2 && i >= 2) {
                double num1 = r / 2;
                double num2 = i / 2;
                double res1 = r % 2;
                double res2 = i % 2;
                System.out.println("Real part " + r + " is divisible by 2 " + (int)num1 + " times\n" +
                        "Imaginary part " + i + " is divisible by 2 " + (int)num2 + " times\n");
                if (res1 != 0 && res2 != 0)
                    this.chain.method(new ComplexNumber(res1, res2));
            } else {
                this.chain.method(number);
            }
        }
}
