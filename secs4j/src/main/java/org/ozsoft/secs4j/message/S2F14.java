package org.ozsoft.secs4j.message;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.ozsoft.secs4j.SecsEquipment;
import org.ozsoft.secs4j.SecsException;
import org.ozsoft.secs4j.SecsParseException;
import org.ozsoft.secs4j.SecsReplyMessage;
import org.ozsoft.secs4j.format.A;
import org.ozsoft.secs4j.format.Data;
import org.ozsoft.secs4j.format.I2;
import org.ozsoft.secs4j.format.L;
import org.ozsoft.secs4j.format.U4;

public class S2F14 extends SecsReplyMessage {

	private static final int STREAM = 2;

	private static final int FUNCTION = 14;

	private static final boolean WITH_REPLY = true;

	private static final String DESCRIPTION = "Equipment Constant Response";
	private static final Logger LOG = Logger.getLogger(S2F14.class);
	private L ec;
	private Map<Long, Data<?>> map = new HashMap<Long, Data<?>> ();
	@Override
	protected void handle() throws SecsException {
		// TODO Auto-generated method stub
		
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
			throw new SecsParseException("S2F14 Missing data");
		}
		if (!(data instanceof L)) {
			throw new SecsParseException("Root data item must be of type L");
		}
		
	}

	@Override
	protected Data<?> getData() throws SecsParseException {
		// TODO Auto-generated method stub(
		if(ec == null || ec.length()==0) {
			
		}
		return ec;
	}
	
	public void setTestData(Data<?> data) {
		
		if(map.size() ==0) {
			A value1 = new A("Good");
			map.put((long) 114, value1);
			I2 value2 = new I2(15);
			map.put((long) 115, value2);
		}
		L l = (L) data;
		U4 dataItem = (U4)l.getItem(0);
		
		Data<?> theValue1 = map.get(dataItem.getValue(0));
		LOG.trace(String.format("Key %s value %s", dataItem.getValue(0), theValue1.getValue()));
		
		dataItem = (U4)l.getItem(1);
		Data<?> theValue2 = map.get(dataItem.getValue(0));
		LOG.trace(String.format("Key %s value %s", dataItem.getValue(0), theValue2.getValue()));
		if(ec == null || ec.length() ==0) {
			ec = new L();
		}
		ec.addItem(theValue1);
		ec.addItem(theValue2);
	}

}
