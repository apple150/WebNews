package it.academy;

import it.academy.dao.NewsDaoImpl;
import it.academy.pojo.NewsPojo;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Test NewsDaoImplTest methods
 */
public class NewsDaoImplTest {
    //Data for test NewsPojo
    private static final int idNum = Integer.MAX_VALUE;
    private static final String annotation = "annotation";
    private static final String author = "author";
    private static final int categoryNum = Integer.MAX_VALUE;
    private static final String header = "header";
    private static final String reldate = "2015-02-17";
    private static final String text = "text";
    //NewsDaoImpl singleton instance
    NewsDaoImpl newsDao = NewsDaoImpl.getNewsDao();

    /*
    Creates test NewsPojo object
     */
    private NewsPojo testObjectNewsPojo() {
        NewsPojo newsPojo = new NewsPojo();
        newsPojo.setId(idNum);
        newsPojo.setAnnotation(annotation);
        newsPojo.setAuthor(author);
        newsPojo.setCategory(categoryNum);
        newsPojo.setHeader(header);
        newsPojo.setReldate(reldate);
        newsPojo.setText(text);
        return newsPojo;
    }

    /*
    Test paramToNewsPojo
     */
    @Test
    public void shouldReturnTrueIfManuallyFormedPojoEqualsMethodFormedPojo() {
        NewsPojo methodCreated = newsDao.paramToNewsPojo(String.valueOf(idNum),
                header,annotation,String.valueOf(categoryNum),author,reldate,text);
        NewsPojo manuallyCreated = testObjectNewsPojo();
        Assert.assertEquals("failure - pojos must be equals", methodCreated, manuallyCreated);
    }
    /*
    Test add, get,update and delete
     */
    @Test
    public void shouldAddGetAndDeleteSingleNewsEntity() {
        List<NewsPojo> news = newsDao.getAll();
        //store count of all news
        int before = news.size();

        //add a single pojo
        NewsPojo newsPojo = testObjectNewsPojo();
        newsDao.add(newsPojo);
        news = newsDao.getAll();
        int afterAdd = news.size();
        //test if it was added
//        Assert.assertEquals("failure - new size must be 1 larger",before+1, afterAdd);

        //Get added news entity
        NewsPojo newsPojoFromDb = newsDao.get(newsPojo.getId());
        //Test for equals of pojos
        Assert.assertEquals("failure - pojos must be equals after add() and get()", newsPojo, newsPojoFromDb);

        //Update news entity

        //set new header
        newsPojo.setHeader("updated");
        //update
        newsDao.update(newsPojo);
        //get that pojo
        newsPojoFromDb = newsDao.get(newsPojo.getId());
        //Test for equals
        Assert.assertEquals("failure - pojos must be equals after update()", newsPojo, newsPojoFromDb);

        //delete that pojo
        newsDao.delete(newsPojo.getId());
        news = newsDao.getAll();
        int afterDelete = news.size();
        Assert.assertEquals("failure - size before test must be equal to size after test", before, afterDelete);
    }
}