package org.firstinspires.ftc.teamcode.KIRIN.Util;

public class SquIDcontroller {

    //floop-floop squiddy boi go BRRRRRRRRRRR\
    //I really wanna eat squid jerky
    /**
     * A squID controller for follower
     * It takes the square root of the P, but otherwise it's pretty normal for a controller
     * <3 thanks Escape Velocity!
     * @author Xander Haemel - 31616
     */
        public double kSq, kI, kD;

        private double integralSum = 0;
        private final double iLimit = 1.0; // TODO: confirm this value

        /**
         * Coefficients:
         * @param kSq Sqrt gain
         * @param kI Integral gain
         * @param kD Derivative gain
         */
        public SquIDcontroller(double kSq, double kI, double kD) {
            super();
            this.kSq = kSq;
            this.kI = kI;
            this.kD = kD;
        }

        public void setSquIDCoefficients(double kSq, double kI, double kD) {
            this.kSq = kSq;
            this.kI = kI;
            this.kD = kD;
        }

        protected double PIDout(double error, double lastError, double deltaTime) {
            // P term (Square Root)
            double proportional = kSq * Math.sqrt(Math.abs(error)) * Math.signum(error);
                //I term
                integralSum += error * deltaTime;
                if (integralSum > iLimit) integralSum = iLimit;
                if (integralSum < -iLimit) integralSum = -iLimit;
                double integral = kI * integralSum;

                // D term
                double derivative = kD * ((error - lastError) / deltaTime);

                return proportional + integral + derivative;
            }
        }


