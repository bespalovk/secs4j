package org.ozsoft.secs4j.message;

import org.ozsoft.secs4j.SecsException;
import org.ozsoft.secs4j.SecsParseException;
import org.ozsoft.secs4j.SecsPrimaryMessage;
import org.ozsoft.secs4j.SecsReplyMessage;
import org.ozsoft.secs4j.format.A;
import org.ozsoft.secs4j.format.Data;
import org.ozsoft.secs4j.format.L;
import org.ozsoft.secs4j.format.U4;

/**
 * S2F13 Equipment Constant Request
 * 
 * @author Yawen Li
 *
 */
public class S2F13 extends SecsPrimaryMessage {

	private static final int STREAM = 2;

	private static final int FUNCTION = 13;

	private static final boolean WITH_REPLY = true;

	private static final String DESCRIPTION = "Equipment Constant Request";

	private L ec;

	public L getEc() {
		return ec;
	}

	public void setEc(L ec) {
		this.ec = ec;
	}

	@Override
	protected SecsReplyMessage handle() throws SecsException {
		// TODO Auto-generated method stub
		S2F14 s2f14 = new S2F14();
		s2f14.setTestData(getData());
		return s2f14;
	}

	@Override
	public int getStream() {
		// TODO Auto-generated method stub
		return STREAM;
	}

	@Override
	public int getFunction() {
		// TODO Auto-generated method stub
		return FUNCTION;
	}

	@Override
	public boolean withReply() {
		// TODO Auto-generated method stub
		return WITH_REPLY;
	}

	@Override
	public String getDescripton() {
		// TODO Auto-generated method stub
		return DESCRIPTION;
	}

	@Override
	protected void parseData(Data<?> data) throws SecsParseException {
		// TODO Auto-generated method stub
		if (data == null) {
			throw new SecsParseException("S2F13 Missing data");
		}
		if (!(data instanceof L)) {
			throw new SecsParseException("Root data item must be of type L");
		}
		L l = (L) data;
		if (l.length() == 0) {
			//set test data
			setTestData();
		}
		ec = l;
	}
	public void setTestData() {
		if (ec == null || ec.length() == 0) {
			// No MDLN and SOFTREV specified; use empty values.
			U4 item1 = new U4(114);
			U4 item2 = new U4(115);
			ec = new L();
			ec.addItem(item1);
			ec.addItem(item2);
		}
	}
	@Override
	protected Data<?> getData() throws SecsParseException {
		// TODO Auto-generated method stub
		if (ec == null || ec.length() == 0) {
			setTestData();
		}
		return ec;
	}
	
}
