const redis = require("redis");

const client = redis.createClient({
    host: process.env.REDIS_HOST,
    port: process.env.REDIS_PORT
  });

console.log("REDIS_HOST", process.env.REDIS_HOST);
console.log("REDIS_PORT, ", process.env.REDIS_PORT);

client.on('error', (err) => console.log('Redis Client Error', err));

await client.connect();

await client.set('key', 'value');
const value = await client.get('key');
await client.disconnect();