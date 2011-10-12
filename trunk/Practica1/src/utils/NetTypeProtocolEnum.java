package utils;

public enum NetTypeProtocolEnum {
    TCP("TCP"), UDP("UDP");
    private String type;

    private NetTypeProtocolEnum(String type) {

    }

    public NetTypeProtocolEnum getNetTypeProtocol(String type) {
	for (NetTypeProtocolEnum protocol : NetTypeProtocolEnum.values()) {
	    if (protocol.getType().equals(type)) {
		return protocol;
	    }
	}
	return null;
    }

    public String getType() {
	return type;
    }

}
