/**
 * CSCI463ProjectTwo: Use MyStack and MyQueue to write a project that check if a sentence is palindrom
 * 
 * @author Justin Henley
 * @version 2020-06-16
 */
import java.util.Scanner;

public class CSCI251ProjectTwo
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        String sentence;
        String again;
        do{
            System.out.println("Enter a sentence, I will tell you if it is a palindrome: ");
            sentence = input.nextLine();
            if(isPalindrome(sentence))
                System.out.println("\"" + sentence + "\" is a palindrome!");
            else
                System.out.println("\"" + sentence + "\" is not a palindrome!");
            System.out.println("Do you want another test (\"YES\" or \"NO\"): ");
            again = input.nextLine();
        }while(again.equalsIgnoreCase("YES"));
    }
    
    /**
     * isPalindrome returns true if the given String is a palindrome
     *
     */
    public static boolean isPalindrome(String sentence)
    {
        // declare a MyStack s
        MyStack<String> s = new MyStack<>();
        // declare a MyQueue q
        MyQueue<String> q = new MyQueue<>();

        // Switch sentence to all-uppercase
        sentence = sentence.toUpperCase();

        for(int i = 0; i < sentence.length(); i++)
        {
            // if ith character in sentence is a letter
            char c = sentence.charAt(i);

            if (Character.isLetter(c)){
                // Push it into s and q
                s.push(Character.toString(c));
                q.push(Character.toString(c));
            }
        }

        while(!s.isEmpty()){
            // if the front of the queue not match the top of stack
            if (!s.peek().contentEquals(q.peek())) {
                // return false
                return false;
            }
            // pop out top of the stack and front of the queue
            s.pop();
            q.pop();
        }
        return true;
    }
}
