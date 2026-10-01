class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()==0){
            return result;
        }
        String[] letters = {
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        backtrack(digits,0,"",result,letters);
        return result;
        }
        private void backtrack(String digits,int index,String current,List<String> result, String[] letters){
            if(index == digits.length()){
                result.add(current);
                return;
            }
            String chars = letters[digits.charAt(index)-'0'];
            for(char ch : chars.toCharArray()){
                backtrack(digits, index + 1, current +ch, result, letters);
            }
      }
}