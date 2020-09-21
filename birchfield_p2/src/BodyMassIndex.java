public class BodyMassIndex {
    private double height;
    private double weight;

    public BodyMassIndex(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double bmiScore() {
        double bmiScore = Math.floor(((703*this.weight)/(Math.pow(this.height, 2)))*10)/10;
        return bmiScore;
    }

    public String bmiCategory() {
        if (this.bmiScore() <= 18.5) {
            return "Underweight";
        } else if (this.bmiScore() <= 24.9) {
            return "Normal weight";
        } else if (this.bmiScore() <= 29.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
}
