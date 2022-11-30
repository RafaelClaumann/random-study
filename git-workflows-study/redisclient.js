const redis = require("redis");

console.log(process.env.REDIS_HOST);
console.log(process.env.REDIS_PORT);

const client = redis.createClient({
    socket: {
        host: process.env.REDIS_HOST,
        port: process.env.REDIS_PORT
    },
    password: "redis2022"
});

client.on("error", err => { console.log("Error " + err); });

async function testCache() {
    client.connect();
    console.log("\nCache command: PING");
    console.log("Cache response: " + await client.ping());
    client.disconnect();
}

testCache();
