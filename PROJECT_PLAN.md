# PaySentry — Intelligent Payment Orchestration Platform

## 1. Aim

Build a single platform that sits between your application and multiple payment
gateways (Stripe, Razorpay, PayPal, etc.) and makes payment processing
**smarter, more resilient, and more observable** — without you writing custom
glue code for every gateway, every failure mode, or every dashboard.

In one sentence: **PaySentry decides the best way to run every payment, heals
itself when things go wrong, and tells you (in plain English) what's happening
and why.**

---

## 2. Core Problem It Solves

Payment stacks today are fragile and opaque:
- A single flaky gateway can silently tank your conversion rate.
- Failed payments are often retried blindly (or not retried at all), losing
  recoverable revenue.
- Fraud/anomaly spikes are caught hours later, in a spreadsheet.
- Ops teams have to grep logs or query 3 different dashboards to answer
  "why did this payment fail?"

PaySentry unifies routing, healing, detection, and explanation into one
concurrent pipeline.

---

## 3. Features (mapped to your requirements)

| Theme | Feature |
|---|---|
| Concise expression of complex payment logic | YAML/JSON **Rules DSL** to define routing, split, retry, and hold logic without code changes |
| API Integrations | Adapter layer for Stripe, Razorpay, PayPal (sandbox/test mode — free) behind one unified interface |
| Intelligent traffic routing | Weighted router picks gateway per-transaction based on live success rate, latency, and cost |
| Self-healing systems | Circuit breaker per gateway; auto-fallback and exponential-backoff retry queue |
| Automatic anomaly detection | Streaming z-score/EWMA detector on success rate, latency, and volume; flags spikes in real time |
| Intelligent payment assist | Natural-language query bot ("why did txn #4821 fail?") backed by an LLM reading your ledger + logs |
| AI-powered payment operations | Auto-generated incident summaries, decline-reason translation, suggested remediations |
| Aesthetic visualization of data | Live dashboard: gateway health, money-flow Sankey, anomaly timeline, retry funnel |

---

## 4. High-Level Workflow

```
                        ┌─────────────────────┐
  Client App  ───POST──▶│   API Gateway (FastAPI)│
                        └──────────┬───────────┘
                                   ▼
                         ┌───────────────────┐
                         │   Rules Engine     │  ← reads rules.yaml
                         │ (routing decision) │
                         └─────────┬──────────┘
                                   ▼
                 ┌─────────────────────────────────┐
                 │  Concurrent Gateway Adapters      │  (asyncio + httpx)
                 │  Stripe | Razorpay | PayPal ...   │
                 └─────────┬───────────┬────────────┘
                            │           │
                     success│    failure│
                            ▼           ▼
                  ┌──────────────┐ ┌────────────────────┐
                  │  Ledger (PG) │ │ Self-Healing Layer  │
                  └──────┬───────┘ │ (circuit breaker +  │
                         │          │  retry queue/Redis) │
                         │          └──────────┬──────────┘
                         ▼                     ▼
                ┌──────────────────┐   (retries loop back to adapters)
                │ Anomaly Detector  │
                │ (stream job)      │
                └──────────┬────────┘
                           ▼
              ┌─────────────────────────┐
              │  WebSocket / Event Bus   │
              └───────────┬─────────────┘
                           ▼
        ┌───────────────────────────────────────┐
        │  Dashboard (React) + AI Assist Chat     │
        └───────────────────────────────────────┘
```

---

## 5. Tech Stack (100% free / open-source or free-tier)

**Backend**
- Python 3.11 + FastAPI — async API layer
- `asyncio` + `httpx.AsyncClient` — concurrent calls to multiple gateways
- Redis (open source) — retry queue, circuit-breaker state, pub/sub for live events
- PostgreSQL — transaction ledger, audit log
- `tenacity` — retry/backoff decorators
- `pybreaker` — circuit breaker implementation
- `numpy` / `pandas` — anomaly scoring (z-score, EWMA)
- `scikit-learn` (optional) — IsolationForest for multivariate anomaly detection

**AI Assist**
- Option A (fully free/local): **Ollama** running Llama 3 / Mistral locally
- Option B (hosted, has free tier): Anthropic Claude API / OpenAI API
- Use function-calling / tool-use pattern so the assistant can query the
  ledger DB and circuit-breaker state before answering

**Frontend**
- React + Vite + TailwindCSS
- Recharts or D3.js — success-rate charts, latency graphs
- Sankey diagram (e.g. `react-sankey` or D3 sankey) — money-flow visualization
- Socket.IO or native WebSocket — live updates

**Payment Gateways (sandbox — free)**
- Stripe Test Mode
- Razorpay Test Mode
- PayPal Sandbox

**Infra / Ops**
- Docker + docker-compose — local orchestration, one command spin-up
- Prometheus + Grafana (optional) — infra-level metrics, complements custom dashboard
- GitHub Actions (free tier) — CI pipeline

---

## 6. Benefits

- **Revenue recovery** — intelligent retries recover payments that naive
  systems would count as lost.
- **Resilience** — one gateway going down doesn't take checkout down with it.
- **Faster incident response** — anomalies surface in seconds, with an AI
  explanation instead of a raw log dump.
- **Lower ops burden** — support staff can ask questions in plain English
  instead of writing SQL.
- **Extensible** — adding a new gateway or a new routing rule is a config
  change, not a code change.
- **Great portfolio project** — touches concurrency, distributed systems
  patterns (circuit breaker, backpressure), applied ML, and AI tool-use in one
  cohesive system.

---

## 7. Suggested Build Order (MVP → Full)

1. **Week 1** — Ledger DB + 2 mock/sandbox gateway adapters + basic FastAPI endpoint
2. **Week 2** — Concurrent routing (`asyncio.gather` race/fallback) + rules DSL
3. **Week 3** — Circuit breaker + retry queue (Redis) = self-healing layer
4. **Week 4** — Anomaly detector (z-score on rolling window) + WebSocket event bus
5. **Week 5** — React dashboard (charts + live feed)
6. **Week 6** — AI assist chat (tool-use over ledger + circuit-breaker state)
7. **Week 7** — Polish, Docker Compose one-command setup, README, demo video

---

## 8. Repo Structure

```
paysentry/
├── backend/
│   ├── app/
│   │   ├── main.py                # FastAPI entrypoint
│   │   ├── rules_engine.py        # loads rules.yaml, decides routing
│   │   ├── adapters/               # one file per gateway
│   │   │   ├── stripe_adapter.py
│   │   │   ├── razorpay_adapter.py
│   │   │   └── paypal_adapter.py
│   │   ├── resilience/
│   │   │   ├── circuit_breaker.py
│   │   │   └── retry_queue.py
│   │   ├── anomaly/
│   │   │   └── detector.py
│   │   ├── ai_assist/
│   │   │   └── assistant.py
│   │   ├── models.py               # SQLAlchemy models
│   │   └── ws.py                   # WebSocket event bus
│   ├── rules.yaml
│   ├── requirements.txt
│   └── Dockerfile
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   └── App.jsx
│   ├── package.json
│   └── Dockerfile
├── docker-compose.yml
└── README.md
```
