const redis = require("redis");

const client = redis.createClient({
    host: process.env.REDIS_HOST,
    port: process.env.REDIS_PORT
  });

console.log("REDIS_HOST", process.env.REDIS_HOST);
console.log("REDIS_PORT, ", process.env.REDIS_PORT);

client.on('error', (err) => console.log('Redis Client Error', err));

async function connect() {
    client.connect();
}

async function setKey() {
    client.set('key', 'value');
}

let value = NaN;
async function retrieveKey() {
    value = client.get('key');
    console.log(value);
}

async function disconnect() {
    client.disconnect();
}

await connect();
await setKey();
await retrieveKey();
await disconnect();