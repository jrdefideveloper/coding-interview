class RunLengthEncoding {

    /**
     * Return it's run length encoding
     * 
     * "AAA" = 3A
     * 
     * Making the assumption that the string length is greater than 1
     * 
     * @param string
     * @return String
     */
    public static String runLengthEncoding(String string) {
        if (string.length() == 1) {
            return "1" + string.charAt(0);
        }
        StringBuilder sb = new StringBuilder();
        int currentRunLength = 1;

        for (int i = 1; i < string.length(); i++) {
            Character prevChar = string.charAt(i - 1);
            Character currentChar = string.charAt(i);

            if (currentChar != prevChar || currentRunLength == 9) {
                sb.append(currentRunLength);
                sb.append(prevChar);
                currentRunLength = 0;
            }

            currentRunLength++;
        }

        sb.append(Integer.toString(currentRunLength));
        sb.append(string.charAt(string.length() - 1));

        return sb.toString();
    }

    public static void main(String[] args) {
        String testcase = "AAAAAAAAAAAAABBCCCCDD"; // ans: 9A4A2B4C2D
        System.out.println(runLengthEncoding(testcase));
    }

}
