public class Palindrome {
    public Deque<Character> wordToDeque(String word)
    {
        LinkedListDeque<Character> deq = new LinkedListDeque<>();
        int n = word.length();
        for(int i = 0; i < n; i++)
            deq.addLast(word.charAt(i));
        return deq;
    }

    public boolean isPalindrome(String word)
    {
        if(word == null)
            return false;
        if(word.length() == 0 && word.length() == 1)
            return true;
        String PalindromeDemo = "";
        Deque a = wordToDeque(word);
        for (int i = 0; i < word.length(); i++) {
            PalindromeDemo += a.removeLast();
        }
        return PalindromeDemo.equals(word);
    }

    public boolean isPalindrome(String word, CharacterComparator cc)
    {
        if(word == null)
            return false;
        String PalindromeDemo = "";
        Deque a = wordToDeque(word);
        for(int i = 0; i < word.length(); i++)
            PalindromeDemo += a.removeLast();
        for(int i = 0; i < word.length() / 2; i++)
            if(!cc.equalChars(word.charAt(i), PalindromeDemo.charAt(i)))
                return false;
        return true;
    }
}
