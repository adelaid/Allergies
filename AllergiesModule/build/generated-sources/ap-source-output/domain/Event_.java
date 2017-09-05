package domain;

import domain.TriggerLocation;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-18T10:30:18")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, String> rTime;
    public static volatile SingularAttribute<Event, String> allergyReaction;
    public static volatile SingularAttribute<Event, TriggerLocation> location;
    public static volatile SingularAttribute<Event, Long> id;

}