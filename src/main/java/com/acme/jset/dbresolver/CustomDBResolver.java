package com.acme.jset.dbresolver;

import ch.qos.logback.classic.db.names.DBNameResolver;

public class CustomDBResolver implements DBNameResolver {

    public <N extends Enum<?>> String getColumnName(N arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    public <N extends Enum<?>> String getTableName(N arg0) {
        // TODO Auto-generated method stub
        return null;
    }

}
