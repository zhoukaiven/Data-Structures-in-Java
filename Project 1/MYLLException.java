/* @author Kaiven Zhou (kz2182)
 * 
 * Custom exception class, thrown when the user attempts to delete a value not in the list
 */
public class MYLLException extends RuntimeException
{
    public MYLLException(String message){
        super(message);
    }
}
