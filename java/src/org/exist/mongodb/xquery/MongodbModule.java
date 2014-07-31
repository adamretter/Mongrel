
package org.exist.mongodb.xquery;

import java.util.List;
import java.util.Map;
import org.exist.dom.QName;
import org.exist.mongodb.xquery.mongodb.Close;
import org.exist.mongodb.xquery.mongodb.Connect;
import org.exist.mongodb.xquery.mongodb.ListDatabases;
import org.exist.mongodb.xquery.mongodb.ListMongdbClientIds;
import org.exist.xquery.AbstractInternalModule;
import org.exist.xquery.FunctionDef;
import org.exist.xquery.XPathException;

/**
 *
 * @author wessels
 */


public class MongodbModule extends AbstractInternalModule {

    public final static String NAMESPACE_URI = "http://exist-db.org/xquery/mongodb";
    public final static String PREFIX = "mongodb";
    public final static String INCLUSION_DATE = "2014-08-01";
    public final static String RELEASED_IN_VERSION = "eXist-2.2";

    public final static FunctionDef[] functions = { 
        new FunctionDef(ListMongdbClientIds.signatures[0], ListMongdbClientIds.class),   
        new FunctionDef(ListDatabases.signatures[0], ListDatabases.class),        
        new FunctionDef(Connect.signatures[0], Connect.class),
        new FunctionDef(Close.signatures[0], Close.class),
        
    };

    public final static QName EXCEPTION_QNAME
            = new QName("exception", MongodbModule.NAMESPACE_URI, MongodbModule.PREFIX);

    public final static QName EXCEPTION_MESSAGE_QNAME
            = new QName("exception-message", MongodbModule.NAMESPACE_URI, MongodbModule.PREFIX);

    public MongodbModule(Map<String, List<? extends Object>> parameters) throws XPathException {
        super(functions, parameters);
    }

    @Override
    public String getNamespaceURI() {
        return NAMESPACE_URI;
    }

    @Override
    public String getDefaultPrefix() {
        return PREFIX;
    }

    @Override
    public String getDescription() {
        return "GridFS module";
    }

    @Override
    public String getReleaseVersion() {
        return RELEASED_IN_VERSION;
    }
}
