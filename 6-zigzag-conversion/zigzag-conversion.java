class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()){
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0;i<numRows;i++){
            rows[i] = new StringBuilder();
        }
        int row=0;
        boolean down = true;
        for(char ch: s.toCharArray()){
            rows[row].append(ch);
            if(row == 0){
                down = true;
            }else if (row == numRows - 1){
                down = false;
            }
            row += down ? 1: -1;
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder r : rows){
            result.append(r);
        }
        return result.toString();
    }
}