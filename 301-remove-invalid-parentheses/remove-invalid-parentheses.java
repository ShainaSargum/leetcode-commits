class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        int leftRemove = 0;
        int rightRemove = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                leftRemove++;
            } else if(c ==')'){
                if(leftRemove > 0){
                    leftRemove--;
                }else{
                    rightRemove ++ ;
                }
            }
        }
        dfs(s, 0, leftRemove, rightRemove, result);
        return result;
    }
    private void dfs(String s, int index, int leftRemove, int rightRemove, List<String> result){
        if(leftRemove == 0 && rightRemove == 0){
            if(isValid(s)){
                result.add(s);
            }
            return;
        }
        for(int i = index; i<s.length(); i++){
            if(i>index && s.charAt(i) == s.charAt(i-1)){
                continue;
            }
            if(leftRemove + rightRemove > s.length()-i){
                return;
            }
            char c = s.charAt(i);
            if(leftRemove > 0 && c =='('){
                dfs(
                    s.substring(0,i) + s.substring(i +1),
                    i,
                    leftRemove -1,
                    rightRemove,
                    result
                );
            }
            if(rightRemove > 0 && c == ')'){
                dfs(
                    s.substring(0,i)+s.substring(i+1),
                    i,
                    leftRemove,
                    rightRemove -1,
                    result
                );
            }
        }
    }
    private boolean isValid(String s){
        int count = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                count++;
            }else if (c==')'){
                count--;
                if(count<0){
                    return false;
                }
            }
        }
        return count == 0;
    }
}