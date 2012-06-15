/**
 * A ListIterator Interface to enable use of previous.
 *
 * @author Tyler Holland
 * @version Program 7
 * @version CPE102-5
 * @version Winter 2009
 */

public interface ListIterator<E> extends java.util.Iterator<E>
{
   public boolean hasPrevious();
   public E previous();
}