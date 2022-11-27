const redis = require("redis");

// Creates a new Redis client
// In the workflow we are going ot set If REDIS_HOST and REDIS_PORT
const redisClient = redis.createClient({
  host: process.env.REDIS_HOST,
  port: process.env.REDIS_PORT
});

console.log("REDIS_HOST", process.env.REDIS_HOST);
console.log("REDIS_PORT, ", process.env.REDIS_PORT);

redisClient.connect();
redisClient.disconnect();
