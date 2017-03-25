

public class MessageClass {
    int senderid,receiverid,id,status,sendertype,receivertype;
    String subject,message;
    MessageClass(int idin,int senderidin,int receiveridin,String subjectin,String messagein,int statusin,int senderinfo,int receiverinfo) {
        id = idin;
        senderid = senderidin;
        receiverid = receiveridin;
        status = statusin;
        subject = subjectin;
        message = messagein;
        sendertype = senderinfo;
        receivertype = receiverinfo;
    }
}