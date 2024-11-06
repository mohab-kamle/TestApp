package UserDefinedFunctionalities;
import java.util.UUID;

/**
 *
 * @author mohab
 */

public class CustomUUIDGenerator {
    private static final String DEFAULT_SEPARATOR = "-";
    
    /**
     * Generates a UUID with a prefix
     * @param prefix String to prepend to the UUID
     * @return UUID formatted as prefix-UUID
     */
    public static UUID generateWithPrefix(String prefix) {
        return UUID.fromString(prefix + DEFAULT_SEPARATOR + UUID.randomUUID().toString());
    }
    
    /**
     * Generates a UUID with both prefix and suffix
     * @param prefix String to prepend to the UUID
     * @param suffix String to append to the UUID
     * @return String formatted as prefix-UUID-suffix
     */
    public static String generateWithPrefixAndSuffix(String prefix, String suffix) {
        return prefix + DEFAULT_SEPARATOR + UUID.randomUUID().toString() + DEFAULT_SEPARATOR + suffix;
    }
    
    /**
     * Generates a UUID with custom format
     * @param prefix String to prepend to the UUID
     * @param includeTimestamp boolean to include timestamp
     * @return String with custom format
     */
    public static String generateCustomFormat(String prefix, boolean includeTimestamp) {
        String timestamp = includeTimestamp ? String.valueOf(System.currentTimeMillis()) : "";
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 12);
        
        if (includeTimestamp) {
            return String.format("%s%s%s%s%s", prefix, DEFAULT_SEPARATOR, timestamp, DEFAULT_SEPARATOR, uuid);
        }
        return String.format("%s%s%s", prefix, DEFAULT_SEPARATOR, uuid);
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(generateWithPrefix("USER"));                    // Output: USER-123e4567-e89b-12d3-a456-426614174000
        System.out.println(generateWithPrefixAndSuffix("ORDER", "TEST")); // Output: ORDER-123e4567-e89b-12d3-a456-426614174000-TEST
        System.out.println(generateCustomFormat("PROD", true));           // Output: PROD-1683921234567-123e4567e89b
    }
}
