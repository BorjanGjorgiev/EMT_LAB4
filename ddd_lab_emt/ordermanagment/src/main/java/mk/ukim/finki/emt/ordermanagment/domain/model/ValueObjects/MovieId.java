package mk.ukim.finki.emt.ordermanagment.domain.model.ValueObjects;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.kernel.domain.base.DomainObjectId;
import org.springframework.web.servlet.ModelAndView;

@Embeddable
public class MovieId extends DomainObjectId
{



    public void randomId()
    {
        Math.random();
    }


   public MovieId()
   {
       super(MovieId.randomId(MovieId.class).getId());
   }

   public MovieId(String uuid)
   {
       super(uuid);
   }


   public static MovieId of(String uuid)
   {
       MovieId m=new MovieId(uuid);
       return m;
   }

}
