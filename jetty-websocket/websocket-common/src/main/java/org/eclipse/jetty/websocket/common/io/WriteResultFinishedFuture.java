//
//  ========================================================================
//  Copyright (c) 1995-2012 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.eclipse.jetty.websocket.common.io;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.eclipse.jetty.websocket.api.WriteResult;

public class WriteResultFinishedFuture extends FutureTask<WriteResult> implements Future<WriteResult>
{
    public static Future<WriteResult> INSTANCE;

    static
    {
        Callable<WriteResult> callable = new Callable<WriteResult>()
        {
            @Override
            public WriteResult call() throws Exception
            {
                return new WriteResult();
            }
        };

        WriteResultFinishedFuture fut = new WriteResultFinishedFuture(callable);
        fut.run();

        INSTANCE = fut;
    }

    public WriteResultFinishedFuture(Callable<WriteResult> callable)
    {
        super(callable);
    }
}
