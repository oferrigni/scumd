/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sshd.client.future;

import org.apache.sshd.common.future.SshFuture;
import org.apache.sshd.common.future.SshFutureListener;
import org.apache.sshd.ClientSession;

/**
 * An {@link SshFuture} for asynchronous connections requests.
 * 
 * @author <a href="mailto:dev@mina.apache.org">Apache MINA SSHD Project</a>
 * @version $Rev: 728642 $, $Date: 2008-12-22 04:48:39 -0600 (Mon, 22 Dec 2008) $
 */
public interface ConnectFuture extends SshFuture<ConnectFuture> {

    ClientSession getSession();

    /**
     * Returns the cause of the connection failure.
     *
     * @return <tt>null</tt> if the connect operation is not finished yet,
     *         or if the connection attempt is successful.
     */
    Throwable getException();

    /**
     * Returns <tt>true</tt> if the connect operation is finished successfully.
     */
    boolean isConnected();

    /**
     * Returns {@code true} if the connect operation has been canceled by
     * {@link #cancel()} method.
     */
    boolean isCanceled();

    /**
     * Sets the newly connected session and notifies all threads waiting for
     * this future.  This method is invoked by SSHD internally.  Please do not
     * call this method directly.
     */
    void setSession(ClientSession session);

    /**
     * Sets the exception caught due to connection failure and notifies all
     * threads waiting for this future.  This method is invoked by SSHD
     * internally.  Please do not call this method directly.
     */
    void setException(Throwable exception);

    /**
     * Cancels the connection attempt and notifies all threads waiting for
     * this future.
     */
    void cancel();

}
