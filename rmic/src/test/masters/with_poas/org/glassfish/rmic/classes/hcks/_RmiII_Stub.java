// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package org.glassfish.rmic.classes.hcks;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.UnexpectedException;
import javax.rmi.CORBA.Stub;
import javax.rmi.CORBA.Util;
import org.omg.CORBA.ORB;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.ApplicationException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.RemarshalException;
import org.omg.CORBA.portable.ResponseHandler;
import org.omg.CORBA.portable.ServantObject;


public class _RmiII_Stub extends Stub implements RmiII {
    
    private static final String[] _type_ids = {
        "RMI:org.glassfish.rmic.classes.hcks.RmiII:0000000000000000"
    };
    
        public String[] _ids() { 
            return (String[]) _type_ids.clone();
        }
        
        public String sayHello() throws java.rmi.RemoteException {
            if (!Util.isLocal(this)) {
                try {
                    org.omg.CORBA_2_3.portable.InputStream in = null;
                    try {
                        OutputStream out = _request("sayHello", true);
                        in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                        return (String) in.read_value(String.class);
                    } catch (ApplicationException ex) {
                        in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                        String $_id = in.read_string();
                        throw new UnexpectedException($_id);
                    } catch (RemarshalException ex) {
                        return sayHello();
                    } finally {
                        _releaseReply(in);
                    }
                } catch (SystemException ex) {
                    throw Util.mapSystemException(ex);
                }
            } else {
                ServantObject so = _servant_preinvoke("sayHello",RmiII.class);
                if (so == null) {
                    return sayHello();
                }
                try {
                    return ((RmiII)so.servant).sayHello();
                } catch (Throwable ex) {
                    Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                    throw Util.wrapException(exCopy);
                } finally {
                    _servant_postinvoke(so);
                }
            }
        }
        
        public int sendBytes(byte[] arg0) throws java.rmi.RemoteException {
            if (!Util.isLocal(this)) {
                try {
                    org.omg.CORBA_2_3.portable.InputStream in = null;
                    try {
                        org.omg.CORBA_2_3.portable.OutputStream out = 
                            (org.omg.CORBA_2_3.portable.OutputStream)
                            _request("sendBytes", true);
                        out.write_value(cast_array(arg0),byte[].class);
                        in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                        return in.read_long();
                    } catch (ApplicationException ex) {
                        in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                        String $_id = in.read_string();
                        throw new UnexpectedException($_id);
                    } catch (RemarshalException ex) {
                        return sendBytes(arg0);
                    } finally {
                        _releaseReply(in);
                    }
                } catch (SystemException ex) {
                    throw Util.mapSystemException(ex);
                }
            } else {
                ServantObject so = _servant_preinvoke("sendBytes",RmiII.class);
                if (so == null) {
                    return sendBytes(arg0);
                }
                try {
                    byte[] arg0Copy = (byte[]) Util.copyObject(arg0,_orb());
                    return ((RmiII)so.servant).sendBytes(arg0Copy);
                } catch (Throwable ex) {
                    Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                    throw Util.wrapException(exCopy);
                } finally {
                    _servant_postinvoke(so);
                }
            }
        }
        
        public Object sendOneObject(Object arg0) throws java.rmi.RemoteException, org.glassfish.rmic.classes.hcks.RmiIMyException {
            if (!Util.isLocal(this)) {
                try {
                    org.omg.CORBA_2_3.portable.InputStream in = null;
                    try {
                        OutputStream out = _request("sendOneObject", true);
                        Util.writeAny(out,arg0);
                        in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                        return Util.readAny(in);
                    } catch (ApplicationException ex) {
                        in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                        String $_id = in.read_string();
                        if ($_id.equals("IDL:org/glassfish/rmic/classes/hcks/RmiIMyEx:1.0")) {
                            throw (org.glassfish.rmic.classes.hcks.RmiIMyException) in.read_value(org.glassfish.rmic.classes.hcks.RmiIMyException.class);
                        }
                        throw new UnexpectedException($_id);
                    } catch (RemarshalException ex) {
                        return sendOneObject(arg0);
                    } finally {
                        _releaseReply(in);
                    }
                } catch (SystemException ex) {
                    throw Util.mapSystemException(ex);
                }
            } else {
                ServantObject so = _servant_preinvoke("sendOneObject",RmiII.class);
                if (so == null) {
                    return sendOneObject(arg0);
                }
                try {
                    Object arg0Copy = (Object) Util.copyObject(arg0,_orb());
                    Object result = ((RmiII)so.servant).sendOneObject(arg0Copy);
                    return (Object)Util.copyObject(result,_orb());
                } catch (Throwable ex) {
                    Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                    if (exCopy instanceof org.glassfish.rmic.classes.hcks.RmiIMyException) {
                        throw (org.glassfish.rmic.classes.hcks.RmiIMyException)exCopy;
                    }
                    throw Util.wrapException(exCopy);
                } finally {
                    _servant_postinvoke(so);
                }
            }
        }
        
        public Object sendTwoObjects(Object arg0, Object arg1) throws java.rmi.RemoteException {
            if (!Util.isLocal(this)) {
                try {
                    org.omg.CORBA.portable.InputStream in = null;
                    try {
                        OutputStream out = _request("sendTwoObjects", true);
                        Util.writeAny(out,arg0);
                        Util.writeAny(out,arg1);
                        in = _invoke(out);
                        return Util.readAny(in);
                    } catch (ApplicationException ex) {
                        in = ex.getInputStream();
                        String $_id = in.read_string();
                        throw new UnexpectedException($_id);
                    } catch (RemarshalException ex) {
                        return sendTwoObjects(arg0,arg1);
                    } finally {
                        _releaseReply(in);
                    }
                } catch (SystemException ex) {
                    throw Util.mapSystemException(ex);
                }
            } else {
                ServantObject so = _servant_preinvoke("sendTwoObjects",RmiII.class);
                if (so == null) {
                    return sendTwoObjects(arg0, arg1);
                }
                try {
                    Object[] copies = Util.copyObjects(new Object[]{arg0,arg1},_orb());
                    Object arg0Copy = (Object) copies[0];
                    Object arg1Copy = (Object) copies[1];
                    Object result = ((RmiII)so.servant).sendTwoObjects(arg0Copy, arg1Copy);
                    return (Object)Util.copyObject(result,_orb());
                } catch (Throwable ex) {
                    Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                    throw Util.wrapException(exCopy);
                } finally {
                    _servant_postinvoke(so);
                }
            }
        }
        
        public String makeColocatedCallFromServant() throws java.rmi.RemoteException {
            if (!Util.isLocal(this)) {
                try {
                    org.omg.CORBA_2_3.portable.InputStream in = null;
                    try {
                        OutputStream out = _request("makeColocatedCallFromServant", true);
                        in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                        return (String) in.read_value(String.class);
                    } catch (ApplicationException ex) {
                        in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                        String $_id = in.read_string();
                        throw new UnexpectedException($_id);
                    } catch (RemarshalException ex) {
                        return makeColocatedCallFromServant();
                    } finally {
                        _releaseReply(in);
                    }
                } catch (SystemException ex) {
                    throw Util.mapSystemException(ex);
                }
            } else {
                ServantObject so = _servant_preinvoke("makeColocatedCallFromServant",RmiII.class);
                if (so == null) {
                    return makeColocatedCallFromServant();
                }
                try {
                    return ((RmiII)so.servant).makeColocatedCallFromServant();
                } catch (Throwable ex) {
                    Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                    throw Util.wrapException(exCopy);
                } finally {
                    _servant_postinvoke(so);
                }
            }
        }
        
        public String colocatedCallFromServant(String arg0) throws java.rmi.RemoteException, java.lang.Exception {
            if (!Util.isLocal(this)) {
                try {
                    org.omg.CORBA_2_3.portable.InputStream in = null;
                    try {
                        org.omg.CORBA_2_3.portable.OutputStream out = 
                            (org.omg.CORBA_2_3.portable.OutputStream)
                            _request("colocatedCallFromServant", true);
                        out.write_value(arg0,String.class);
                        in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                        return (String) in.read_value(String.class);
                    } catch (ApplicationException ex) {
                        in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                        String $_id = in.read_string();
                        if ($_id.equals("IDL:java/lang/Ex:1.0")) {
                            throw (java.lang.Exception) in.read_value(java.lang.Exception.class);
                        }
                        throw new UnexpectedException($_id);
                    } catch (RemarshalException ex) {
                        return colocatedCallFromServant(arg0);
                    } finally {
                        _releaseReply(in);
                    }
                } catch (SystemException ex) {
                    throw Util.mapSystemException(ex);
                }
            } else {
                ServantObject so = _servant_preinvoke("colocatedCallFromServant",RmiII.class);
                if (so == null) {
                    return colocatedCallFromServant(arg0);
                }
                try {
                    return ((RmiII)so.servant).colocatedCallFromServant(arg0);
                } catch (Throwable ex) {
                    Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                    if (exCopy instanceof java.lang.Exception) {
                        throw (java.lang.Exception)exCopy;
                    }
                    throw Util.wrapException(exCopy);
                } finally {
                    _servant_postinvoke(so);
                }
            }
        }
        
        public String throwThreadDeathInServant(String arg0) throws java.rmi.RemoteException {
            if (!Util.isLocal(this)) {
                try {
                    org.omg.CORBA_2_3.portable.InputStream in = null;
                    try {
                        org.omg.CORBA_2_3.portable.OutputStream out = 
                            (org.omg.CORBA_2_3.portable.OutputStream)
                            _request("throwThreadDeathInServant", true);
                        out.write_value(arg0,String.class);
                        in = (org.omg.CORBA_2_3.portable.InputStream)_invoke(out);
                        return (String) in.read_value(String.class);
                    } catch (ApplicationException ex) {
                        in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                        String $_id = in.read_string();
                        throw new UnexpectedException($_id);
                    } catch (RemarshalException ex) {
                        return throwThreadDeathInServant(arg0);
                    } finally {
                        _releaseReply(in);
                    }
                } catch (SystemException ex) {
                    throw Util.mapSystemException(ex);
                }
            } else {
                ServantObject so = _servant_preinvoke("throwThreadDeathInServant",RmiII.class);
                if (so == null) {
                    return throwThreadDeathInServant(arg0);
                }
                try {
                    return ((RmiII)so.servant).throwThreadDeathInServant(arg0);
                } catch (Throwable ex) {
                    Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                    throw Util.wrapException(exCopy);
                } finally {
                    _servant_postinvoke(so);
                }
            }
        }
        
        public Object returnObjectFromServer(boolean arg0) throws java.rmi.RemoteException {
            if (!Util.isLocal(this)) {
                try {
                    org.omg.CORBA.portable.InputStream in = null;
                    try {
                        OutputStream out = _request("returnObjectFromServer", true);
                        out.write_boolean(arg0);
                        in = _invoke(out);
                        return Util.readAny(in);
                    } catch (ApplicationException ex) {
                        in = ex.getInputStream();
                        String $_id = in.read_string();
                        throw new UnexpectedException($_id);
                    } catch (RemarshalException ex) {
                        return returnObjectFromServer(arg0);
                    } finally {
                        _releaseReply(in);
                    }
                } catch (SystemException ex) {
                    throw Util.mapSystemException(ex);
                }
            } else {
                ServantObject so = _servant_preinvoke("returnObjectFromServer",RmiII.class);
                if (so == null) {
                    return returnObjectFromServer(arg0);
                }
                try {
                    Object result = ((RmiII)so.servant).returnObjectFromServer(arg0);
                    return (Object)Util.copyObject(result,_orb());
                } catch (Throwable ex) {
                    Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                    throw Util.wrapException(exCopy);
                } finally {
                    _servant_postinvoke(so);
                }
            }
        }
        
        // This method is required as a work-around for
        // a bug in the JDK 1.1.6 verifier.
        
        private Serializable cast_array(Object obj) {
            return (Serializable)obj;
        }
    }
