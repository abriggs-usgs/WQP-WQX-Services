package gov.usgs.cida.wqp.transform;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import gov.usgs.cida.wqp.mapping.OrganizationColumn;
import gov.usgs.cida.wqp.service.ILogService;

public class OrganizationSumMapToJsonTransformer extends BaseMapToJsonTransformer {

	public OrganizationSumMapToJsonTransformer(OutputStream target, Map<String, String> mapping, ILogService logService, Integer logId, String siteUrlBase) {
		super(target, mapping, logService, logId, siteUrlBase);
	}

	@Override
	protected void writeHeader() {
		try {
			g.writeStartObject();
			g.writeFieldName("organization");
			g.writeStartArray();
		} catch (IOException e) {
			throw new RuntimeException("Error starting json document", e);
		}
	}

	@Override
	protected void writeData(Map<String, Object> resultMap) {
		try {
			g.writeStartObject();

			g.writeStringField("organizationID", getValue(resultMap, OrganizationColumn.KEY_ORGANIZATION));
			g.writeStringField("organizationFormalName", getValue(resultMap, OrganizationColumn.KEY_ORGANIZATION_NAME));
			g.writeStringField("organizationType", getValue(resultMap, OrganizationColumn.KEY_ORGANIZATION_TYPE));
			g.writeStringField("organizationWQPUrl", getValue(resultMap, OrganizationColumn.KEY_ORGANIZATION_SUMMARY_WQP_URL));
			g.writeStringField("lastResultSubmittedDate", getValue(resultMap, OrganizationColumn.KEY_LAST_RESULT));
			g.writeStringField("totalMonitoringLocationsSampled", getValue(resultMap, OrganizationColumn.KEY_SITE_COUNT));
			g.writeStringField("totalActivities", getValue(resultMap, OrganizationColumn.KEY_ACTIVITY_COUNT));

			g.writeFieldName("yearlySummary");
			g.writeRawValue(getValue(resultMap, OrganizationColumn.KEY_ORGANIZATION_SUMMARY));

			g.writeEndObject();
		} catch (IOException e) {
			throw new RuntimeException("Error writing json for Organization Summary", e);
		}
	}

	/** output the closing tags and close stuff as appropriate. */
	@Override
	public void end() {
		try {
			g.writeEndArray();
			g.writeEndObject();
			g.close();
		} catch (IOException e) {
			throw new RuntimeException("Error ending json document", e);
		}
	}

}
